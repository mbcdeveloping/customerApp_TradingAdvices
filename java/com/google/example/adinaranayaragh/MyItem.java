package com.google.example.adinaranayaragh;


public class MyItem {
    String title;
    Sellm sell;
    Buy buy;

    public MyItem(){

    }


    public String getTitleOfItem() {
        return title;
    }

    public void setTitleOfItem(String title) {
        this.title = title;
    }

    public Sellm getSell() {
        return sell;
    }

    public void setSell(Sellm sell) {
        this.sell = sell;
    }

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }


    public class Buy{
        String buyBellow;
        String date;
        String target1;
        String target2;
        String stoploss;

        public Buy(){

        }


        public String getBuyBellow() {
            return buyBellow;
        }



        public String getDate() {
            return date;
        }



        public String getTarget1() {
            return target1;
        }



        public String getTarget2() {
            return target2;
        }



        public String getStoploss() {
            return stoploss;
        }



    }

    public class Sellm{
        String sellAbove;
        String date;
        String target1;
        String target2;
        String stoploss;

        public Sellm(){

        }

        public String getSellAbove() {
            return sellAbove;
        }


        public String getDate() {
            return date;
        }



        public String getTarget1() {
            return target1;
        }



        public String getTarget2() {
            return target2;
        }



        public String getStoploss() {
            return stoploss;
        }


    }
}
