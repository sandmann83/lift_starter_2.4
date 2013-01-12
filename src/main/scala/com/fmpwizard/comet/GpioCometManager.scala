package com.fmpwizard.comet

import net.liftweb.actor.LiftActor
import net.liftweb.http.ListenerManager
import com.fmpwizard.{PinPWM, PinAction, PinPulse, PinToggle}
import com.fmpwizard.gpio.Controller
import net.liftweb.common.Loggable
import com.pi4j.io.gpio.GpioPinPwmOutput

/**
 * This LiftActor tells all comet actors in this jvm when a pin state has changed.
 */
object GpioCometManager extends LiftActor with ListenerManager with Loggable {

  var pin: PinAction = PinPWM((Controller.pin1, 20))

  def createUpdate = pin
  override def lowPriority = {
    case m@PinToggle(currentPi) =>
      currentPi.toggle()
      pin = m
      logger.info("3- pin is: " + pin)
      updateListeners()
    case m@ PinPWM((currentPin: GpioPinPwmOutput, turn: Int)) =>
      currentPin.setPwm(turn)
      logger.info("4- PinPWM Pin: %s turn: %s".format(currentPin, turn))
      pin = m
      updateListeners()
  }
}

