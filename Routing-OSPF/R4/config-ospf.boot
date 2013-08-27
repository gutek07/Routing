interfaces {
    ethernet eth0 {
        address 10.50.20.2/28
        duplex auto
        ip {
            ospf {
                cost 100
                dead-interval 40
                hello-interval 10
                priority 1
                retransmit-interval 5
                transmit-delay 1
            }
        }
        smp_affinity auto
        speed auto
    }
    ethernet eth1 {
        address 10.50.30.1/28
        duplex auto
        smp_affinity auto
        speed auto
    }
}
protocols {
    ospf {
        area 0.0.0.0 {
            network 10.50.20.0/28
            network 10.50.30.0/28
        }
        parameters {
            abr-type cisco
            router-id 10.50.30.1
        }
        redistribute {
            connected {
                metric-type 2
            }
        }
    }
}
system {
    config-management {
        commit-revisions 20
    }
    console {
        device ttyS0 {
            speed 9600
        }
    }
    host-name R4
    login {
        user root {
            authentication {
                encrypted-password $1$wblnuRHY$N.fPndbqucxfU.29NS6lr.
                plaintext-password ""
            }
            level admin
        }
        user vyatta {
            authentication {
                encrypted-password $1$4JeZ2P4Z$7TIaZ4smYZ8oQF9sqHdyW.
            }
            level admin
        }
    }
    ntp {
    }
    time-zone GMT
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "quagga@2:webproxy@1:wanloadbalance@3:ipsec@4:conntrack-sync@1:vrrp@1:config-management@1:zone-policy@1:nat@4:cluster@1:dhcp-relay@1:dhcp-server@4:qos@1:firewall@5:conntrack@1:webgui@1:system@6" === */
/* Release version: VC6.6R1 */
