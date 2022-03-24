// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

plugins {
  id 'java'
  id 'org.jetbrains.intellij' version '1.4.0'
}

group 'org.intellij.sdk'
version '2.0.0'

sourceCompatibility = 11

repositories {
  mavenCentral()
}

test {
  // This path value is machine-specific placeholder text.
  // Set idea.home.path to the absolute path to the intellij-community source
  // on your local machine.
  // Use variants described in https://docs.gradle.org/current/userguide/build_environment.html
  // for real world projects.
  systemProperty "idea.home.path", "/Users/jhake/Documents/source/comm"
}

// Include the generated files in the source set
sourceSets.main.java.srcDirs 'src/main/gen'

dependencies {
  testImplementation group: 'junit', name: 'junit', version: '4.13.2'
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
  version = '2021.1.3'
  plugins = ['com.intellij.java']
}

buildSearchableOptions {
  enabled = false
}

patchPluginXml {
  version = project.version
  sinceBuild = '211'
  untilBuild = '213.*'
}
