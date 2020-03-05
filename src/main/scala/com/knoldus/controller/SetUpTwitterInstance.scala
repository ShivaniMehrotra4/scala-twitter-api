package com.knoldus.controller

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




