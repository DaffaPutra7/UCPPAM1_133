package com.example.ucp_pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Ucp(modifier: Modifier = Modifier){

    Column(
        modifier = modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ){
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),

            ){
                Box(
                    contentAlignment = Alignment.BottomEnd,
                ){
                    Image(painter = painterResource(R.drawable.umy),
                        contentDescription = null,
                        modifier = Modifier.clip(CircleShape).size(100.dp)
                    )
                    Image(painter = painterResource(R.drawable.verif),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
                Column(
                    modifier = Modifier.padding(15.dp)
                ){
                    Text(text = "Halo, ")
                    Text(text = "Muhammad Adri")
                }
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        IsiData()
    }
}

@Composable
fun IsiData(modifier: Modifier = Modifier){
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var tahun by remember { mutableStateOf("") }

    var dataTahun = listOf("2020", "2021", "2022")

    var confirmEmail by remember { mutableStateOf("") }
    var confirmAlamat by remember { mutableStateOf("") }
    var confirmNotelepon by remember { mutableStateOf("") }
    var confirmTahun by remember { mutableStateOf("") }

    Text(text = "Masukkan Biodata Kamu!")
    Text(text = "Silahkan isi data dengan sebenar-benarnya")
    Column (
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ){
            Column(

            ){
                TextField(
                    value = email,
                    onValueChange = {email = it},
                    label = {
                        Text(text = "Nama")
                    },
                    placeholder = {
                        Text(text = "Isi Nama Anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                )
                TextField(
                    value = alamat,
                    onValueChange = {alamat = it},
                    label = {
                        Text(text = "Alamat")
                    },
                    placeholder = {
                        Text(text = "Isi Alamat Anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                )
                TextField(
                    value = notelepon,
                    onValueChange = {notelepon = it},
                    label = {
                        Text(text = "No.Telepon")
                    },
                    placeholder = {
                        Text(text = "Isi No.Telepon Anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Row (modifier = Modifier.fillMaxWidth()){
                    dataTahun.forEach{selectedTahun->
                        Row (verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = tahun == selectedTahun,
                                onClick = {tahun = selectedTahun}
                            )
                            Text(text = selectedTahun)}
                    }
                }
            }
        }

        Button(onClick = {
            confirmEmail = email
            confirmAlamat = alamat
            confirmNotelepon = notelepon
            confirmTahun = tahun
        },
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Simpan")

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray).padding(20.dp)
        ){
            Column(

            ){
                Text(text = "Data Kamu", style = TextStyle())
                TampilData(
                    param = "email",
                    argu = confirmEmail
                )
                TampilData(
                    param = "alamat",
                    argu = confirmAlamat
                )
                TampilData(
                    param = "notelepon",
                    argu = confirmNotelepon
                )
                TampilData(
                    param = "tahun",
                    argu = confirmTahun
                )
            }
        }
    }
}

@Composable
fun TampilData(
    param : String, argu : String
){
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = param,
                modifier = Modifier.weight(0.8f))
            Text(text = ": ",
                modifier = Modifier.weight(0.2f))
            Text(text = argu,
                modifier = Modifier.weight(2f))
        }
    }
}