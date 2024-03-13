/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parivaar.org.util;

import de.huxhorn.sulky.ulid.ULID;

/**
 *
 * @author hp
 */
public class ULIDGenerator {
    
    private static ULID ulid = null;
    
    static{
        ulid = new ULID();
    }
    
    public static String getULID(){
        return ulid.nextULID(); 
    }
}
