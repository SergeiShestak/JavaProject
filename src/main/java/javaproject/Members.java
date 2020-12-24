package javaproject;

public class Members {

    private char memberType;
    private int memberId;
    private String name;
    private double fees;

    public Members(char pMemberType,int pMemberId,String pName,double pFees){
        memberType = pMemberType;
        memberId = pMemberId;
        name = pName;
        fees =pFees;
    }

    public void setMemberType(char pMemberType) {
        memberType = pMemberType;
    }
    public char getMemberType(){
        return memberType;
    }

    public void setMemberId(int pMemberId){
        memberId = pMemberId;
    }
    public int getMemberId(){
        return memberId;
    }

    public void setName(String pName){
        name = pName;
    }
    public String getName(){
        return name;
    }

    public void setFees(double pFees){
        fees = pFees;
    }
    public double getFees(){
        return fees;
    }

    @Override
    public String toString(){
        return getMemberType()+", "+ getMemberId() +", "+ getName() +", "+ getFees();
    }

}
