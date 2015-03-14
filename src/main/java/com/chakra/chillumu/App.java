package com.chakra.chillumu;

import java.util.Arrays;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import com.restfb.types.User;

/**
 * To get my fb info.
 *
 */
public class App {

	private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAFlTCJdjZC5mV4DjVl5iUkmdcYRIiVoeL58aXewS6CfFMVWU09ttZCJOWVsysgRs6ZCNTPVsoIuzXJhJPXEdFfE72n7VibUy5FkX1mgvZC5hKtPZAdh6ZAiIfhUI6yggPzWZCWQPvBcWN6L6Sf2JQgN7ZBTJdjrs5HMJt6qjhn5SWZCbyZBvahDzaZBWZA2sV6XIDmh4Gr9hX95iZAgrG4KSWentLBOxlzGerCX6ZBfnmhtHKZBZAHqljh6ZAqyAZD";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println("Hello World!");

		// DefaultFacebookClient is the FacebookClient implementation
		// that ships with RestFB. You can customize it by passing in
		// custom JsonMapper and WebRequestor implementations, or simply
		// write your own FacebookClient instead for maximum control.

		FacebookClient facebookClient = new DefaultFacebookClient(
				MY_ACCESS_TOKEN);

		Connection<User> myFriends = facebookClient.fetchConnection(
				"me/friends", User.class);
		Connection<Post> myFeed = facebookClient.fetchConnection("me/feed",
				Post.class);

		/*
		 * Connection<User> targetedSearch = facebookClient.fetchConnection(
		 * "me/home", User.class, Parameter.with("q", "Avinash"),
		 * Parameter.with("type", "user"));
		 */

		FetchObjectsResults fetchObjectsResults = facebookClient.fetchObjects(
				Arrays.asList("me", "cocacola"), FetchObjectsResults.class);

		System.out
				.println("Count of my friends: " + myFriends.getData().size());
		System.out.println("First item in my feed: " + myFeed.getData().get(0));

		/*
		 * System.out.println("Posts on my wall by friends named Avinash: " +
		 * targetedSearch.getData().size());
		 */

		System.out.println("User name: " + fetchObjectsResults.me.getName());
		System.out
				.println("Page likes: " + fetchObjectsResults.page.getLikes());

	}
}
