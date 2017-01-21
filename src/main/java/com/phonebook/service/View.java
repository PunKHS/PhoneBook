package com.phonebook.service;

/**
 * Планируется использовать для сериализации объектов с помощью @JsonView.
 */
public class View {
    public static class REST {}
    public static class UI {}
    public static class Autocomplete {}
    public static class UIplus extends UI {}
}


