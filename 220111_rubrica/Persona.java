public class Persona {
    String name;
    String surname;
    String cellNumber;

    Persona(String name, String surname, String cellNumber){
        this.name = name;
        this.surname = surname;
        this.cellNumber =  cellNumber;
    }

    public String toString(){
        // return "Name: "+this.name+", Surname: "+this.surname+", Telephone number: "+this.cellNumber;
        return this.name+" | "+this.surname+" | "+this.cellNumber;
    }
}