/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		
		    // FACTORY PATTERN
        User user1 = UserFactory.createUser("STUDENT", "ibrahim");
        User user2 = UserFactory.createUser("STUDENT", "rafay");
        user1.dashboard();
        user2.dashboard();

        // FACADE PATTERN
        HostelFacade hostel = new HostelFacade();
        hostel.studentOperations();

        // STRATEGY PATTERN
        FeeChoice choosefee = new FeeChoice(new MonthlyFee());
        choosefee.executePayment();
		
	}
}
