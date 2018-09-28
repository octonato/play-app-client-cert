# Client certificate playground

```
sbt runProd
```

```
curl --trace-ascii -  https://localhost:9443 --key clientCerts/MyClient1.key  --cert clientCerts/MyClient1.pem --cert-type PEM --cacert playgenerated-selfsigned.crt 
curl -vvv  https://localhost:9443 --key clientCerts/MyClient1.key  --cert clientCerts/MyClient1.pem --cert-type PEM --cacert playgenerated-selfsigned.crt 
curl -vvv  https://localhost:9443 --key server.key  --cert server.crt --cert-type PEM --cacert playgenerated-selfsigned.crt 
```