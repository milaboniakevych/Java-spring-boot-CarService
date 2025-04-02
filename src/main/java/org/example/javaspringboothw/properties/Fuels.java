package org.example.javaspringboothw.properties;


import lombok.Data;

import java.util.List;

@Data
public class Fuels {
    private String name;
    private List<String> types;

}
