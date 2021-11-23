package demo.h2.domain;

public enum FieldType {

    USERNAME("username"),
    PASSWORD("password"),
    FIRSTNAME("firstname"),
    LASTNAME("lastname"),
    EMAIL("email");

    private String value;

    FieldType(String value) {
        this.value = value;
    }

    FieldType() {

    }

    public String getValue() {
        return value;
    }

}
