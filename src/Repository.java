public class Repository {

    public void Repository(){
        String Matr_27[][] = { {"Т1", "С1", "Т2","Т4","Т5"," "," "},
                             {"Т5", "Т1", "Т3","Т2","Т4"," "," "},
                             {"Т5", "С1", "Т1","Т2","Т3","Ф2","Ф3"},
                             {"Т1", "С1", "Т2","Т3","Т4"," "," "},
                             {"Т2", "С2", "Т3","Т4","Т5"," "," "},
                             {"Т1", "С3", "Ф2","Т4","Т5"," "," "},
                             {"Т1", "С1", "Т2","Т3","С2","Т4","Т5"},};
        OperationMatrix OperationMatrix_27 = new OperationMatrix(Matr_27);
        OperationMatrix_27.display();
    }

}