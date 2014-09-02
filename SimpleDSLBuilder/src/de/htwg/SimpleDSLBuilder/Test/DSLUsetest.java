package de.htwg.SimpleDSLBuilder.Test;

import static de.htwg.generated.User.UserBuilder.user;
import de.htwg.generated.User.ForumBuilder;
import de.htwg.user.Address;
import de.htwg.user.User;

public class DSLUsetest {

	public static void main(String[] args) {
		User steven = user("Steven").lastName("Boeckle").email("SBoeckle@freenet.de").address(new Address()).optionalAge(25).optionalPhone("01234342453").buildUser();
		System.out.println(steven);
		ForumBuilder.user().firstName("asd").lastName("asd").email("awdawd").buildUser().address().street("adwaw").buildAddress().buildForum();
	}

}
