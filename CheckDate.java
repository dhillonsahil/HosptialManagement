interface DateCheck{
    public boolean check(int checkDate , int checkMonth , int checkYear ,int date , int month , int year);
}

class CheckDate implements DateCheck {
    
     public boolean check(int checkDate , int checkMonth , int checkYear ,int date , int month , int year){
        if(checkDate==date && checkMonth==month && checkYear==year){
            return true;
        }else{
            return false;
        }
     }
}
