cmake_minimum_required(VERSION 3.14)
project(kanban_app LANGUAGES CXX)

set(BINARY_NAME "kanban_app")

cmake_policy(SET CMP0087 NEW)

set(FLUTTER_MANAGED_DIR "${CMAKE_CURRENT_SOURCE_DIR}/flutter")

get_filename_component(FLUTTER_ROOT "$ENV{FLUTTER_ROOT}" ABSOLUTE)
if(NOT EXISTS "${FLUTTER_ROOT}")
  message(FATAL_ERROR "Flutter SDK not found. Define FLUTTER_ROOT environment variable.")
endif()

set(FLUTTER_EPHEMERAL_DIR "${CMAKE_CURRENT_SOURCE_DIR}/flutter/ephemeral")

include("${FLUTTER_ROOT}/packages/flutter_tools/gradle/flutter.gradle" OPTIONAL)
include("${FLUTTER_MANAGED_DIR}/generated_plugins.cmake" OPTIONAL)

add_subdirectory(runner)
