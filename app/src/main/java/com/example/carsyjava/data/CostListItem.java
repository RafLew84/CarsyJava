package com.example.carsyjava.data;

public abstract class CostListItem {
    public static final int TYPE_YEAR = 0;
    public static final int TYPE_MONTH = 1;
    public static final int TYPE_GENERAL = 2;

    abstract public int getType();

    public static class CostGeneralItem extends CostListItem {
        private final Cost cost;

        public Cost getCost() {
            return cost;
        }

        public CostGeneralItem(Cost cost){
            this.cost = cost;
        }


        @Override
        public int getType() {
            return TYPE_GENERAL;
        }
    }

    public static class CostMonthItem extends CostListItem {
        private final String month;

        public CostMonthItem(String month) {
            this.month = month;
        }

        public String getMonth() {
            return month;
        }

        @Override
        public int getType() {
            return TYPE_MONTH;
        }
    }

    public static class CostYearItem extends CostListItem {
        private final String year;

        public CostYearItem(String year) {
            this.year = year;
        }

        public String getYear() {
            return year;
        }

        @Override
        public int getType() {
            return TYPE_YEAR;
        }
    }
}
