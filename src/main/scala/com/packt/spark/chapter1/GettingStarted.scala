package com.packt.spark.chapter1

import org.apache.spark._

object GettingStarted {
  def getSparkContext(): SparkContext = {
    val conf = 
      new SparkConf()
        .setMaster("local[4]")
        .setAppName("Coding with Spark")

    new SparkContext(conf)
  }

  def main(args: Array[String]): Unit = {
    val sc = getSparkContext()

    try {
      val path = new java.io.File("./data/Parking_Violations-sample.csv").getAbsolutePath

      val rdd =
        sc.textFile(s"file://$path")

      val count = rdd.count

      println(f"\nCount is ${count}%,d.\n")
    } finally {
      sc.stop()
    }
  }
}