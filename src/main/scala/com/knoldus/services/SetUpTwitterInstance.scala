package com.knoldus.services

import com.typesafe.config.ConfigFactory
import twitter4j.auth.AccessToken
import twitter4j.{Query, QueryResult, Status, Twitter, TwitterFactory}
import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions

class SetUpTwitterInstance {

  def getInstanceTwitter: Twitter = {

    val config = ConfigFactory.load()
    val twitter: Twitter = new TwitterFactory().getInstance()
    twitter.setOAuthConsumer(config.getString("consumer.key"), config.getString("consumer.secret"))
    twitter.setOAuthAccessToken(new AccessToken(config.getString("token.key"), config.getString("token.secret")))
    twitter

  }

  def getTweets(twitter: Twitter,hashTag :String): Future[List[Status]] = {
    val query = new Query(hashTag)
    val queryResult: Future[QueryResult] = Future(twitter.search(query))
    val futureListOfTweets: Future[List[Status]] = queryResult.map(status => status.getTweets.asScala.toList)
    futureListOfTweets
  }.fallbackTo(Future {
    List.empty[Status]
  })
}




/*
package com.knoldus.services

import com.typesafe.config.ConfigFactory
import twitter4j.auth.AccessToken
import twitter4j.{Twitter, TwitterFactory}

import scala.language.implicitConversions

class SetUpTwitterInstance {

  def getInstanceTwitter: Twitter = {

    val config = ConfigFactory.load()
    val twitter: Twitter = new TwitterFactory().getInstance()
    twitter.setOAuthConsumer(config.getString("consumer.key"), config.getString("consumer.secret"))
    twitter.setOAuthAccessToken(new AccessToken(config.getString("token.key"), config.getString("token.secret")))
    twitter

  }
}


 */