package Mortgage;

public class HousePrices extends Users {

    private int price;

    public HousePrices(String username, String wichCondition, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        super(username, wichCondition, houseType, roomCount, downPayment, longTerm, statesTax);
        conditionToPrice();
        houseTypeToPrice();
        roomCountToPrice();
        calculateTax();
    }

    public void roomCountToPrice(){
        switch (getRoomCount()){
            case 0:
                this.price+=10000;break;
            case 1:
                this.price+=20000;break;
            case 2:
                this.price+=30000;break;
            case 3:
                this.price+=40000;break;
            case 4:
                this.price+=50000;break;
            case 5:
                this.price+=60000;break;
            default:
                System.out.println("Odalarımız 0 ile 5 arasındadır.");
        }
    }

    public void conditionToPrice(){
        if (getWichCondition().equalsIgnoreCase("new")){
            this.price+=50000;
        } else if (getWichCondition().equalsIgnoreCase("like new")) {
            this.price+=40000;
        } else if (getWichCondition().equalsIgnoreCase("old")) {
            this.price+=30000;
        } else if (getWichCondition().equalsIgnoreCase("renew required")) {
            this.price+=15000;
        }
    }

    public void houseTypeToPrice(){
        if (getHouseType().equalsIgnoreCase("apartment")){
            this.price+=20000;
        } else if (getHouseType().equalsIgnoreCase("condo")) {
            this.price+=30000;
        } else if (getHouseType().equalsIgnoreCase("house")) {
            this.price+=40000;
        }
    }

    public void calculateTax(){
        this.price+=(getPriceTotal()*getStatesTax().getTax())/100;
    }

    public int getPriceTotal(){
        return this.price;
    }

    public int getPriceEachMonth(){
        return (this.price-getDownPayment())/getLongTerm();
    }



}




