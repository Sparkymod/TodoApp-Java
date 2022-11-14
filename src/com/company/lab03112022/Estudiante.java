package com.company.lab03112022;

public class Estudiante extends Persona implements IGestorAsignatura, IGestorBiblioteca {
    private String matricula;
    private String[] asignaturas;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Estudiante() {
        setId(1000);
        setNombreCompleto("N/A");
        setEdad(0);
        setMatricula("00-0000");
        setAsignaturas(new String[10]);
    }

    @Override
    public void inscribirAsignatura(String asignatura) {
        agregarORemoverAsignatura(asignatura, true);
    }

    @Override
    public void retirarAsignatura(String asignatura) {
        agregarORemoverAsignatura(asignatura, false);
    }

    @Override
    public void reservarLibro() {
        System.out.println("Reservando Libro...");
    }

    // Metodo reutilizable para agregar o remover.
    private void agregarORemoverAsignatura(String asignatura, boolean estaAgregando) {

        // Retornamos si el parametro está vacío
        if (asignatura.isEmpty()){
            System.err.println("Parametro de asignatura vacía, no hay nada que hacer.");
            return;
        }
        // Obtenemos la lista actual de las asignaturas y la guardamos
        String[] listaAsignaturas = getAsignaturas();

        // Guardamos la cantidad máxima de las asignaturas actuales
        int cantidadAsignatura = listaAsignaturas.length;

        // Creamos una nueva lista vacía con 1 espacio más que la cantidad máxima.
        String[] nuevaListaAsignatura = new String[cantidadAsignatura + 1];

        // Agregamos o Eliminamos de la lista.
        if (estaAgregando) {
            // Recorremos cada asignatura y la reasignamos en la nueva lista.
            for (int i = 0; i < cantidadAsignatura; i++) {

                // Reasignamos los valores del arreglo en su posición.
                nuevaListaAsignatura[i] = listaAsignaturas[i];
            }

            // Una vez asignamos la nueva lista, agregamos la nueva asignatura.
            nuevaListaAsignatura[cantidadAsignatura] = asignatura;

            // Devolvemos la lista nueva al campo privado.
            setAsignaturas(nuevaListaAsignatura);

        } else {

            // Recorremos cada asignatura y la reasignamos en la nueva lista.
            for (int i = 0; i <= cantidadAsignatura; i++) {

                // Verificamos que el valor que accedemos al arreglo existe.
                if (cantidadAsignatura > i) {

                    // Si la asignatura existe, remuevela de la lista.
                    if(!listaAsignaturas[i].equals(asignatura)){
                        nuevaListaAsignatura[i] = listaAsignaturas[i];
                    }
                }
            }

            // Devolvemos la lista nueva al campo privado.
            setAsignaturas(nuevaListaAsignatura);
        }
    }

    @Override
    public void obtenerInfo() {
        String info = "ID: " + getId() + "\n" + "Nombre Completo: " + getNombreCompleto() + "\n";
        info += "Edad: " + getEdad() + "\n" + "Matrícula: " + getMatricula() + "\n";

        if (getAsignaturas() != null && getAsignaturas().length > 0) {
            int count = 1;
            for (String asignatura : asignaturas) {
                if (asignatura == null || asignatura.isEmpty()) {
                    continue;
                }
                info += "Asignatura #" + (count++) + ": " + asignatura + "\n";
            }
        }

        System.out.println(info);
    }
}
