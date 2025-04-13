package Designs.Splitwise.Expense;

import Designs.Splitwise.Expense.Split.EqualExpenseSplit;
import Designs.Splitwise.Expense.Split.ExpenseSplit;
import Designs.Splitwise.Expense.Split.PercentageExpenseSplit;
import Designs.Splitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}

