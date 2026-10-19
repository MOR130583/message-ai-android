# Message AI — Android prototype

Android prototype for opt-in WhatsApp Business notification capture and manual review. Working name only.

## Scope (phase 1)
- Start collecting only after the user explicitly enables Android Notification Access.
- Capture new notification text from WhatsApp Business (package `com.whatsapp.w4b`), with timestamps.
- Local storage; no account, no cloud upload, no auto-replies.
- Manual **Scan** button reviews captured notifications; shows last scan date/time and capture counts.
- Group filtering is a planned feature; muted chats and messages without notifications are **not reliably captured**.
- Later: summaries, voice interface, draft replies and optional Google Calendar.

## Privacy and limitations
Notification access is a powerful Android permission. No history is imported. The app must clearly communicate gaps, deduplicate updates, and provide a delete-data control before external testing. No claim of complete coverage is made.

## Building
This is an initial source scaffold, not a compiled or tested APK. Open in Android Studio and add a Gradle Android application configuration before building. No device testing has been performed.
