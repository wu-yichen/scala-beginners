package exercises

import lectures.part2oop.CaseClass.Person

object MapExercise extends App {
  /*
    social network based on map
    person - string
    1. Add
    2. remove
    3. friend(mutual)
    4. unfriend

    - num of friends of a person
    - person with most friends
    - how many people have no friends
    - if there is a social connect between two people
   */
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def remove(friends: Set[String], newNetwork: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) newNetwork
      else remove(friends.tail, unfriend(newNetwork, person, friends.head))
    }
    val network2 = remove(network(person), network)
    network2 - person
  }

  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsOfA = network(personA)
    val friendsOfB = network(personB)
    network + (personA -> (friendsOfA + personB)) + (personB -> (friendsOfB + personA))
  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsOfA = network(personA)
    val friendsOfB = network(personB)
    network + (personA -> (friendsOfA - personB)) + (personB -> (friendsOfB - personA))
  }

  def numOfFriends(network: Map[String, Set[String]], person: String): Int =
    network(person).size

  def personWithMostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  def numOfPeopleHaveNoFriends(network: Map[String, Set[String]]): Int =
    network.count(pair => pair._2.isEmpty)

  val network = add(add(add(add(add(Map(), "XIAO WANG"), "GANG"),"da"),"qu"),"ll")
  println(network)
  val network2 = friend(friend(friend(network, "qu","da"), "GANG", "da"),"GANG", "XIAO WANG")
  println(network2)
  val network3 = remove(network2, "qu")
  println(network3)

  println(numOfFriends(network3, "GANG"))
  println(personWithMostFriends(network3))
  println(numOfPeopleHaveNoFriends(network3))
}
