package akka.actor

import akka.testkit.AkkaSpec

@org.junit.runner.RunWith(classOf[org.scalatest.junit.JUnitRunner])
class ClusterSpec extends AkkaSpec {

  "ClusterSpec: A Deployer" must {
    "be able to parse 'akka.actor.cluster._' config elements" in {

      // TODO: make it use its own special config?
      val config = system.settings.config
      import config._

      //akka.cluster
      getString("akka.cluster.name") must equal("test-cluster")
      getString("akka.cluster.zookeeper-server-addresses") must equal("localhost:2181")
      getInt("akka.remote.server.port") must equal(2552)
      getInt("akka.cluster.max-time-to-wait-until-connected") must equal(30)
      getInt("akka.cluster.session-timeout") must equal(60)
      getInt("akka.cluster.connection-timeout") must equal(60)
      getInt("akka.remote.remote-daemon-ack-timeout") must equal(30)
      getBoolean("akka.cluster.include-ref-node-in-replica-set") must equal(true)
      getString("akka.remote.layer") must equal("akka.cluster.netty.NettyRemoteSupport")
      getString("akka.remote.secure-cookie") must equal("")
      getBoolean("akka.remote.use-passive-connections") must equal(true)
      getString("akka.cluster.log-directory") must equal("_akka_cluster")

      //akka.cluster.replication
      getString("akka.cluster.replication.digest-type") must equal("MAC")
      getString("akka.cluster.replication.password") must equal("secret")
      getInt("akka.cluster.replication.ensemble-size") must equal(3)
      getInt("akka.cluster.replication.quorum-size") must equal(2)
      getInt("akka.cluster.replication.snapshot-frequency") must equal(1000)
      getInt("akka.cluster.replication.timeout") must equal(30)

      //akka.remote.server
      getInt("akka.remote.server.port") must equal(2552)
      getInt("akka.remote.server.message-frame-size") must equal(1048576)
      getInt("akka.remote.server.connection-timeout") must equal(120)
      getBoolean("akka.remote.server.require-cookie") must equal(false)
      getBoolean("akka.remote.server.untrusted-mode") must equal(false)
      getInt("akka.remote.server.backlog") must equal(4096)

      //akka.remote.client
      getBoolean("akka.remote.client.buffering.retry-message-send-on-failure") must equal(false)
      getInt("akka.remote.client.buffering.capacity") must equal(-1)
      getInt("akka.remote.client.reconnect-delay") must equal(5)
      getInt("akka.remote.client.read-timeout") must equal(3600)
      getInt("akka.remote.client.reap-futures-delay") must equal(5)
      getInt("akka.remote.client.reconnection-time-window") must equal(600)
    }
  }
}
