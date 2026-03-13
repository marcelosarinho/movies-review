package com.marcelosarinho.moviereview.entity.enums;

public enum Interest {
    HIGH(1, "Alto"),
    MEDIUM(2, "Médio"),
    LOW(3, "Baixo");

    private int code;
    private String name;

    Interest(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Interest valueOf(int code) {
        for (Interest interest: Interest.values()) {
            if (code == interest.getCode()) {
                return interest;
            }
        }

        throw new IllegalArgumentException("Invalid Interest code!");
    }
}
