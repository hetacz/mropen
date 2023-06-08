package com.qualityminds.mropen.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Envs {

    DEV("https://risksuite-dev.munichre.com/"),
    INT("https://risksuite-int.munichre.com/"),
    PROD("https://risksuite.munichre.com/");

    private final String url;
}
