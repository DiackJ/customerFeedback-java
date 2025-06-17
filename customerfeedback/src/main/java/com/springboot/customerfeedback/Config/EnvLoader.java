package com.springboot.customerfeedback.Config;

import io.github.cdimascio.dotenv.Dotenv;

//fallback class to ensure env values are loaded upon program initialization
public class EnvLoader{

    public static void loader(){
        Dotenv dotenv = Dotenv.configure()
                .filename(".env")
                .load();

        System.setProperty("MONGO_DATABASE", dotenv.get("MONGO_DATABASE"));
        System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
    }
}
