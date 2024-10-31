public enum TransactionType {
    CASH_WITHDRAWAL,
    CHECK_BALANCE;

    public static void showAllTransactionTypes(){
        for(TransactionType transactionType : TransactionType.values()){
            System.out.println(transactionType.name());
        }
    }
}
