/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.library;

/**
 *
 * @author ryany
 */
public class LibraryFactory {
     public Library createLibrary(String libraryType) {
        switch (libraryType) {
            case "Academic":
                return new AcademicLibrary();
            case "Public":
                return new PublicLibrary();
            default:
                throw new IllegalArgumentException("Unknown library type: " + libraryType);
        }
    }  
}
