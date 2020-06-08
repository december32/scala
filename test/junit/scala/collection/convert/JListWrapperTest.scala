package scala.collection.convert

import java.{util => ju}

import org.junit.Assert.assertTrue
import org.junit.Test
import scala.collection.JavaConverters._
import scala.collection.immutable.List
import scala.collection.mutable.Buffer

@deprecated("Tests deprecated API", since="2.13")
class JListWrapperTest {

  @Test
  def testIteratorDoesNotCauseStackOverflow(): Unit = {
    val jList: ju.List[Int] = ju.Arrays.asList(1, 2, 3)
    val sList: Buffer[Int] = jList.asScala

    assertTrue(sList.isInstanceOf[JavaCollectionWrappers.JListWrapper[_]])
    assertTrue(sList.iterator.sameElements(List(1, 2, 3)))
  }
}
