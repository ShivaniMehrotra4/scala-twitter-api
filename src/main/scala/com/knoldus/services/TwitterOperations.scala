package com.knoldus.services

import twitter4j.Status

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions

class TwitterOperations {


  def getNumberOfTweets(futureListOfTweets: Future[List[Status]]): Future[Int] = {
    futureListOfTweets.map(listOfTweets => listOfTweets.length)
  }.fallbackTo(Future {
    -1
  })

  def getTweetLikes(futureListOfTweets: Future[List[Status]]): Future[List[Int]] = {
    val futureFavCount = futureListOfTweets.map(listOfTweets => listOfTweets.map(tweets => tweets.getFavoriteCount))
    futureFavCount
  }.fallbackTo(Future {
    List.empty[Int]
  })

  def getTweetsPerDay(futureListOfTweets: Future[List[Status]]): Future[Int] = {
    val res = futureListOfTweets.map(listOfTweets => listOfTweets.map(tweets => tweets.getCreatedAt.getTime).distinct.length)
    val res1: Future[Int] = futureListOfTweets.map(v => res.map(v.length / _)).flatten
    res1
  }.fallbackTo(Future {
    -1
  })

  def getAverageOfFavCount(futureFavCount: Future[List[Int]]): Future[Int] = {
    val futureSum = futureFavCount.map(_.sum)
    val avg: Future[Int] = futureSum.map(sum => futureFavCount.map(sum / _.length)).flatten
    avg
  }.fallbackTo(Future {
    -1
  })

  def getRetweetCount(futureListOfTweets: Future[List[Status]]): Future[List[Int]] = {
    val retweet = futureListOfTweets.map(listOfTweets => listOfTweets.map(tweets => tweets.getRetweetCount))
    retweet
  }.fallbackTo(Future {
    List.empty[Int]
  })
}


/*
package com.knoldus.services

import twitter4j.{Query, QueryResult, Status, Twitter}

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions

class TwitterOperations {

  def getQueryResult(twitter: Twitter, hashTag: String): Future[QueryResult] = {
    val query = new Query(hashTag)
    val queryResult: Future[QueryResult] = Future(twitter.search(query))
    queryResult
  }

  def getTweets(futureQueryResult: Future[QueryResult]): Future[List[Status]] = {
    val futureListOfTweets: Future[List[Status]] = futureQueryResult.map(res => res.getTweets.asScala.toList)
    futureListOfTweets
  }.fallbackTo(Future {
    List.empty[Status]
  })

  def getNumberOfTweets(futureListOfTweets: Future[List[Status]]): Future[Int] = {
    futureListOfTweets.map(listOfTweets => listOfTweets.length)
  }.fallbackTo(Future {
    -1
  })

  def getTweetLikes(futureListOfTweets: Future[List[Status]]): Future[List[Int]] = {
    val futureFavCount = futureListOfTweets.map(listOfTweets => listOfTweets.map(tweets => tweets.getFavoriteCount))
    futureFavCount
  }.fallbackTo(Future {
    List.empty[Int]
  })

  def getTweetsPerDay(futureListOfTweets: Future[List[Status]]): Future[Int] = {
    val res = futureListOfTweets.map(listOfTweets => listOfTweets.map(tweets => tweets.getCreatedAt.getTime).distinct.length)
    val res1: Future[Int] = futureListOfTweets.map(v => res.map(v.length / _)).flatten
    res1
  }.fallbackTo(Future {
    -1
  })

  def getAverageOfFavCount(futureFavCount: Future[List[Int]]): Future[Int] = {
    val futureSum = futureFavCount.map(_.sum)
    val avg: Future[Int] = futureSum.map(sum => futureFavCount.map(sum / _.length)).flatten
    avg
  }.fallbackTo(Future {
    -1
  })

  def getRetweetCount(futureListOfTweets: Future[List[Status]]): Future[List[Int]] = {
    val retweet = futureListOfTweets.map(listOfTweets => listOfTweets.map(tweets => tweets.getRetweetCount))
    retweet
  }.fallbackTo(Future {
    List.empty[Int]
  })
}

 */