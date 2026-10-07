#!/bin/bash

# ==============================================================================
# Raspberry Pi LED Control CGI Script (using gpiod)
#
# This script controls a GPIO pin based on a URL query string using the
# `gpioset` command-line tool. It is designed for Apache's mod_cgi.
#
# URL examples:
# http://<your-pi-ip>/cgi-bin/led-toggle.sh?state=on
# http://<your-pi-ip>/cgi-bin/led-toggle.sh?state=off
# ==============================================================================

# --- Configuration ---
# The name of the GPIO chip. On most Raspberry Pi models, this is "gpiochip0".
# You can verify by running `gpiodetect` in the terminal.

# gpioset GPIO17=1

# The GPIO pin number (using BCM numbering).
GPIO_PIN="GPIO17"

# --- Main Logic ---
# This function reads the QUERY_STRING environment variable (provided by Apache)
# and performs the requested action using gpioset.
toggle_led() {
  # Parse the query string to find the desired state.
  case "$QUERY_STRING" in
    "state=on")
      # Set the GPIO pin to 1 (high/on).
      # The command is `gpioset <chip> <pin>=<value>`
      gpioset -t0 "${GPIO_PIN}=1"
      echo "Status: OK. LED turned ON."
      ;;
    "state=off")
      # Set the GPIO pin to 0 (low/off).
      gpioset -t0  "${GPIO_PIN}=0"
      echo "Status: OK. LED turned OFF."
      ;;
    *)
      # If the query string is invalid, return an error message.
      echo "Status: Error. Invalid command."
      echo "Usage: ?state=on or ?state=off"
      ;;
  esac
}


# --- CGI Output ---
# A CGI script MUST output a valid HTTP header first.
# Here, we specify the content type is plain text, followed by a blank line.
echo "Content-type: text/plain"
echo ""

# Execute the main logic function.
# Its output will be sent back to the browser.
toggle_led

exit 0