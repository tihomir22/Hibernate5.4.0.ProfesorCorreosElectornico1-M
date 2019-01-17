/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.HashSet;
import java.util.Set;
import model.CorreoElectronico;
import model.Direccion;
import model.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Maite
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CREAMOS CONEXION
        //SessionFactory sessionFactory;
        //Configuration configuration = new Configuration();
        //configuration.configure();
        //sessionFactory = configuration.buildSessionFactory();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // CREAMOS UN OBJETO
        Direccion dir = new Direccion(8, "Calle la reina", 5, "Xativa", "Valencia");
        Profesor profesor = new Profesor(17, "Pepe", "Garcia", "Perez");
        profesor.setDireccion(dir);
        Set<CorreoElectronico> correosElectronicos = new HashSet<>();
        CorreoElectronico correo1 = new CorreoElectronico(1343, "tihomir_alcudia3@hotmail.com", profesor);
        CorreoElectronico correo2 = new CorreoElectronico(3432, "tihomir_alcudia4@hotmail.com", profesor);
        CorreoElectronico correo3 = new CorreoElectronico(43343, "tihomir_alcudia5@hotmail.com", profesor);
        correosElectronicos.add(correo1);
        correosElectronicos.add(correo2);
        correosElectronicos.add(correo3);
        profesor.setCorreosElectronicos(correosElectronicos);
        
        //CREAR UNA SESION
        Session session = factory.openSession();
        session.beginTransaction();

        //GUARDAR OBJETO
        session.saveOrUpdate(profesor);

        Profesor profesor2 = session.get(Profesor.class, 1);

        profesor.setNombre("Jorge");
        session.update(profesor);

        session.delete(profesor);

        session.saveOrUpdate(profesor);

        //CERRAR CONEXION
        session.getTransaction().commit();
        session.close();
        factory.close();

    }

}
