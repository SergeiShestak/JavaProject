package javaproject;

public class MultiClubMember extends Members {

    private int memberShipPoint;

    MultiClubMember(char pMemberType, int pMemberId, String pName, double pFees,int pMemberShipPoint){
        super(pMemberType, pMemberId, pName, pFees);
        memberShipPoint = pMemberShipPoint;
    }

    public void setMemberShipPoint(int pMemberShipPoint){
        memberShipPoint = pMemberShipPoint;
    }
    public int getMemberShipPoint(){
        return memberShipPoint;
    }
    @Override
    public String toString(){
        return super.toString() + ", "+ getMemberShipPoint();
    }

}
