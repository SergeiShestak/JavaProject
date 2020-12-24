package javaproject;

public class SingleClubMember extends Members {

    private int club;

    public SingleClubMember(char pMemberType, int pMemberId, String pName, double pFees,int pClub) {
        super(pMemberType, pMemberId, pName, pFees);
        club = pClub;
    }

    public void setClub(int pClub){
        club = pClub;
    }
    public int getClub(){
        return club;
    }

    @Override
    public String toString(){
        return super.toString()+ ", " + getClub();
    }
}
