package Main;

public class Validator {
    protected boolean checkId(String id) {
        return (id.matches("[U]-[0-9]{4}"));
    }

    protected boolean checkPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$";
        return password.matches(regex);
    }


    protected boolean checkChoice(String choices) {
        return choices.matches("[0-9]");
    }
    protected boolean checkName(String name) {
        return name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    }

//    public boolean checkTime(String time){return time.matches("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)");}
    public boolean checkTime(String time){
        return time.matches("^((0[1-9])|(1[0-2])):[0-5][0-9](\\s)?(?i)(am|pm)$");
    }
}

