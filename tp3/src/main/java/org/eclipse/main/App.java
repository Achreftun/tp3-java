package org.eclipse.main;

import org.eclipse.dao.UtilisateurDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
        var utilisateurs = utilisateurDaoImpl.getAll();
        utilisateurs.forEach(System.out::println);
        System.out.println("---------------");
        System.out.println(utilisateurDaoImpl.findByNomAndPrenom("wick", "john"));
        System.out.println(utilisateurDaoImpl.findByNomAndPrenom("tyson", "mike"));
    }
}
