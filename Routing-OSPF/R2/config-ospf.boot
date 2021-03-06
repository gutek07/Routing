interfaces {
    ethernet eth0 {
        address 10.50.0.2/28
        duplex auto
        ip {
            ospf {
                cost 10
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
        address 10.50.10.1/28
        duplex auto
        smp_affinity auto
        speed auto
    }
}
protocols {
    ospf {
        area 0.0.0.0 {
            network 10.50.0.0/28
            network 10.50.10.0/28
        }
        parameters {
            abr-type cisco
            router-id 10.50.10.1
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
    host-name R2
    login {
        user root {
            authentication {
                encrypted-password $1$ixUZffYu$leehHklzrso.chmATM2sC.
                plaintext-password ""
            }
            level admin
        }
        user vyatta {
            authentication {
                encrypted-password $1$9FSPJh6h$YFSoJq.Fx.x4g0pvIOYCQ.
            }
            level admin
        }
    }
    ntp {
    }
    time-zone GMT
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "zone-policy@1:cluster@1:dhcp-relay@1:webproxy@1:nat@4:wanloadbalance@3:quagga@2:dhcp-server@4:system@6:qos@1:vrrp@1:config-management@1:webgui@1:firewall@5:conntrack-sync@1:ipsec@4:conntrack@1" === */
/* Release version: VC6.6R1 */
