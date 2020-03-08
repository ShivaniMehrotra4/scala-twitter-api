/*
package com.knoldus.controller

import com.knoldus.services.{SetUpTwitterInstance, TwitterOperations}
import twitter4j.{QueryResult, Status}
import scala.concurrent.Future

class TwitterHandler (twitterInstance: SetUpTwitterInstance,twitterOperations: TwitterOperations) {

  val allTweets: Future[List[Status]] = twitterOperations.getTweets(twitterInstance.getInstanceTwitter,"#Angular")

  val numberOfTweets: Future[Int] = twitterOperations.getNumberOfTweets(allTweets)
//  Thread.sleep(9000)
//    println("Total number of Tweets : " + numberOfTweets)

  val tweetLikes: Future[List[Int]] = twitterOperations.getTweetLikes(allTweets)
//  Thread.sleep(9000)
//  println("Tweet Likes : " + tweetLikes)

  val tweetsPerDay: Future[Int] = twitterOperations.getTweetsPerDay(allTweets)
//  Thread.sleep(9000)
//  println("Tweet Per Day : " + tweetsPerDay)

  val favCount: Future[Int] = twitterOperations.getAverageOfFavCount(tweetLikes)
//  Thread.sleep(9000)
//  println("Avg. Sum of favourite Tweets : " + favCount)

  val retweetCount: Future[List[Int]] = twitterOperations.getRetweetCount(allTweets)
//  Thread.sleep(9000)
//  println("Retweet count : " + retweetCount)

}
*/
/*

package com.knoldus.controller

import com.knoldus.services.{SetUpTwitterInstance, TwitterOperations}
import twitter4j.{QueryResult, Status}
import scala.concurrent.Future

object TwitterHandler extends App {

  val twitterInstance = new SetUpTwitterInstance
  val twitterObject = twitterInstance.getInstanceTwitter

  val top = new TwitterOperations
  val queryResult: Future[QueryResult] = top.getQueryResult(twitterObject, "#Angular")
  Thread.sleep(9000)
  print(queryResult)
  val allTweets: Future[List[Status]] = top.getTweets(queryResult)

  val noOfTweets = top.getNumberOfTweets(allTweets)
  Thread.sleep(9000)
    println("Total number of Tweets : " + noOfTweets)

  val tweetLikes = top.getTweetLikes(allTweets)
  Thread.sleep(9000)
  println("Tweet Likes : " + tweetLikes)

  val tweetsPerDay = top.getTweetsPerDay(allTweets)
  Thread.sleep(9000)
  println("Tweet Per Day : " + tweetsPerDay)

  val favCount = top.getAverageOfFavCount(tweetLikes)
  Thread.sleep(9000)
  println("Avg. Sum of favourite Tweets : " + favCount)

  val retweetCount = top.getRetweetCount(allTweets)
  Thread.sleep(9000)
  println("Retweet count : " + retweetCount)

}
*/

