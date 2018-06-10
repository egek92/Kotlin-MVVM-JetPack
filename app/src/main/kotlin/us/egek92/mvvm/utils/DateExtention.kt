package us.egek92.mvvm.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 01:01.
 * Copyright (c) 2018. All rights reserved.
 */
fun Date.simpleDateFormat(): String {
  return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(this)
}

fun Date.simpleTimeFormat(): String {
  return SimpleDateFormat("HH:mm", Locale.getDefault()).format(this)
}