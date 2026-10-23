plain_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
cipher_alphabet = "ꙮᛝ⦓╩🜕⏈╬◕𓎛╪𓋇⸎ᚼ༽⎶ᚵ𐍁☈ᛋᛏ⁜⧇℘つᛦ𐎚◇⸾𐌀∌ⶩ⦡⍝Ⲋ⧉🜏"

translation = {}
for plain, cipher in zip(plain_alphabet, cipher_alphabet):
    if plain.isalpha():
        translation[ord(plain)] = f"⁞{cipher}⁞"
        translation[ord(plain.lower())] = cipher
    else:
        translation[ord(plain)] = cipher

while True:
    plain_text = input(": ")
    print(plain_text.translate(translation))
