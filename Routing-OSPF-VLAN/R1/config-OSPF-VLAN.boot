interfaces {
    ethernet eth1 {
        address 10.50.0.1/28
        duplex auto
        smp_affinity auto
        speed auto
    }
    ethernet eth2 {
        address 10.50.30.2/28
        duplex auto
        smp_affinity auto
        speed auto
    }
}
protocols {
    ospf {
        area 0.0.0.0 {
            network 10.50.30.0/28
            network 10.50.0.0/28
        }
        parameters {
            abr-type cisco
            router-id 10.50.0.1
        }
        redistribute {
            connected {
                metric-type 2
            }
        }
    }
}
system {
    host-name vyatta
    login {
        user vyatta {
            authentication {
                encrypted-password $1$vItLLFNX$6wiGwNimkj63dvpxKogqw0
                plaintext-password ""
            }
            level admin
        }
    }
    time-zone GMT
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "quagga@2:qos@1:system@6:dhcp-relay@1:dhcp-server@4:webproxy@1:vrrp@1:ipsec@4:wanloadbalance@3:config-management@1:zone-policy@1:webgui@1:firewall@5:nat@4:conntrack-sync@1:conntrack@1:cluster@1" === */
/* Release version: VC6.6R1 */
