require efl++.inc

EXTRA_QMAKEVARS_POST += "CONFIG+=eflecorex11"
PV = "0.1.0+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@projects.linuxtogo.org/cvsroot/eflpp;module=efl++"
S = "${WORKDIR}/efl++"


