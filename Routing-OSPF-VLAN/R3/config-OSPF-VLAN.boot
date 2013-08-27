interfaces {
    ethernet eth0 {
        address 10.50.10.2/28
        duplex auto
        hw-id 08:00:27:90:17:97
        smp_affinity auto
        speed auto
    }
    ethernet eth1 {
        address 192.168.0.1/24
        description LAN
        duplex auto
        hw-id 08:00:27:fa:22:d7
        smp_affinity auto
        speed auto
        vif 40 {
            address 192.168.40.1/28
        }
        vif 50 {
            address 192.168.50.1/24
        }
        vif 60 {
            address 192.168.60.1/30
        }
    }
    ethernet eth2 {
        address 10.50.20.1/28
        duplex auto
        hw-id 08:00:27:fe:56:c4
        smp_affinity auto
        speed auto
    }
}
protocols {
    ospf {
        area 0.0.0.0 {
            network 10.50.10.0/28
            network 192.168.0.0/24
            network 192.168.40.0/28
            network 10.50.20.0/28
        }
        parameters {
            abr-type cisco
            router-id 10.50.10.2
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
        user root {
            authentication {
                encrypted-password $1$UzRd9HqF$zuGDIDrQxXmDhB2cmiyrs.
                plaintext-password ""
            }
            level admin
        }
        user vyatta {
            authentication {
                encrypted-password $1$f4/e5qs7$XRbo7ByduQkrQY545o85E.
                plaintext-password ""
            }
            level admin
        }
    }
    time-zone GMT
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "quagga@2:webproxy@1:wanloadbalance@3:ipsec@4:conntrack-sync@1:vrrp@1:config-management@1:zone-policy@1:nat@4:cluster@1:dhcp-relay@1:dhcp-server@4:qos@1:firewall@5:conntrack@1:webgui@1:system@6" === */
/* Release version: VC6.6R1 */
