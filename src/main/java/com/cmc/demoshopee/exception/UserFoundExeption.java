package com.cmc.demoshopee.exception;

public class UserFoundExeption extends RuntimeException{
    public UserFoundExeption(){
        super("User with this Username is already there in DB !! try with another one");
    }
    public UserFoundExeption(String msg){
        super(msg);
    }
}
