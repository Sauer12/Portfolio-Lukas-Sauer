from kivy.app import App
from kivy.uix.floatlayout import FloatLayout


class Interface(FloatLayout):
    def display_information(self):
        data = self.ids.textInput.text
        self.ids.label.text = data

class ProjectApp(App):
    pass

ProjectApp().run()