package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.UserTypePermissionTemplate;
import com.diagnocons.ris.domain.repository.UserTypePermissionTemplateRepository;
import com.diagnocons.ris.persistence.crud.PlantillaPermisosTipoUsuarioCrudRepository;
import com.diagnocons.ris.persistence.entity.PlantillaPermisosTipoUsuario;
import com.diagnocons.ris.persistence.mapper.UserTypePermissionTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlantillaPermisosTipoUsuarioRepository implements UserTypePermissionTemplateRepository {

    @Autowired
    private PlantillaPermisosTipoUsuarioCrudRepository plantillaPermisosTipoUsuarioCrudRepository;

    @Autowired
    private UserTypePermissionTemplateMapper mapper;

    @Override
    public Optional<List<UserTypePermissionTemplate>> getByIdPermission(Long idPermission) {
        return plantillaPermisosTipoUsuarioCrudRepository.findByIdPermiso(idPermission).map(list -> mapper.toUsersTypesPermissionsTemplates(list));
    }

    @Override
    public Optional<List<UserTypePermissionTemplate>> getByIdUserType(Long idUserType) {
        Optional<List<PlantillaPermisosTipoUsuario>> encontrados = plantillaPermisosTipoUsuarioCrudRepository.findByIdTipoUsuario(idUserType);
        return encontrados.map(list -> mapper.toUsersTypesPermissionsTemplates(list));
    }

    public Optional<UserTypePermissionTemplate> getById(Long id) {
        return plantillaPermisosTipoUsuarioCrudRepository.findById(id).map(plant -> mapper.toUserTypePermissionTemplate(plant));
    }

    @Override
    public Optional<List<UserTypePermissionTemplate>> getAll() {
        List<PlantillaPermisosTipoUsuario> todos = (List<PlantillaPermisosTipoUsuario>)plantillaPermisosTipoUsuarioCrudRepository.findAll();
        return Optional.of(mapper.toUsersTypesPermissionsTemplates(todos));
    }

    @Override
    public UserTypePermissionTemplate save(UserTypePermissionTemplate userTypePermissionTemplate) {
        PlantillaPermisosTipoUsuario plantilla = mapper.toPlantillaPermisosTipoUsuario(userTypePermissionTemplate);
        return mapper.toUserTypePermissionTemplate(plantillaPermisosTipoUsuarioCrudRepository.save(plantilla));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            plantillaPermisosTipoUsuarioCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
