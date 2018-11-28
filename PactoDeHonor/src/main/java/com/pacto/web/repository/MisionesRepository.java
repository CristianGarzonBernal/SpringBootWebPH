package com.pacto.web.repository;

import com.pacto.web.model.Misiones;
import com.pacto.web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository("misionesRepository")
public interface MisionesRepository extends JpaRepository<Misiones, Integer> {

    @Query(value = "Select m FROM Misiones m WHERE m.autor like :autor")
    Collection<Misiones> findMisionesByAutor(@Param("autor") String autor);

    @Query(value = "SELECT DISTINCT\n" +
            "misiones.Nombre_mision as nm, misiones.descripcion_mision as dm," +
            " misiones.mecanica as mec, pregunta.pregunta as pre,pregunta.descripcion as des, respuesta_htp.respuesta as resp, name as na, last_name as last, sex as sex\n" +
            "FROM user\n" +
            "INNER JOIN heroe ON heroe.Id_user = user.user_id\n" +
            "INNER JOIN pregunta_heroe ON pregunta_heroe.id_heroe = heroe.id_heroe\n" +
            "INNER JOIN pregunta ON pregunta_heroe.id_pregunta = pregunta.id_pregunta\n" +
            "INNER JOIN respuesta_htp_heroe ON respuesta_htp_heroe.id_heroe = heroe.id_heroe\n" +
            "INNER JOIN respuesta_htp ON respuesta_htp.id_pregunta = pregunta.id_pregunta\n" +
            "INNER JOIN misiones ON misiones.Id_mision = pregunta_heroe.Id_Mision\n" +
            "WHERE misiones.id_mision IN :array",nativeQuery = true)
    Collection<Map> findMisionesByIds(@Param("array")Integer [] array);
}
