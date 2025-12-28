
python do_generate_info (){
    pn = d.getVar('PN')
    bpn = d.getVar('BPN')
    pv = d.getVar('PV')
    bpn = d.getVar('BPN')
    buildhost = d.getVar('BUILDHOST')
    target_arch = d.getVar('TARGET_ARCH')

    machine = d.getVar('MACHINE')
    
    s_dir = d.getVar('S')
    b_dir = d.getVar('B')
    d_dir = d.getVar('D')

    workdir = d.getVar('WORKDIR')
    
    bindir = d.getVar('bindir')

    bb.warn(f"\nHello {pn}")
    bb.warn(f"\nHello {bpn}")
    bb.warn(f"\nHello {pv}")
    
    if "raspberrypi4-64" == machine:
        bb.plain(f"\nBuild for {machine}")

    bb.warn(f"D dir: {d_dir}\n B dir: {b_dir}\n S dir: {s_dir}")
    bb.warn(f"Bindir: {bindir}")
}

addtask do_generate_info after do_compile before do_install